package com.business95.api.service.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.dto.request.ActualizarContrasenaPorCorreoRequest;
import com.business95.api.dto.request.ActualizarMiContrasenaRequest;
import com.business95.api.dto.request.ActualizarSocioRequest;
import com.business95.api.dto.request.RegistrarSocioRequest;
import com.business95.api.dto.response.ActividadRecienteResponse;
import com.business95.api.dto.response.BalanceAnualSocioResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoRecienteResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.SocioResponse;
import com.business95.api.entity.Socio;
import com.business95.api.entity.Usuario;
import com.business95.api.exception.SocioNoEncontradoException;
import com.business95.api.exception.UsuarioNoEncontradoException;
import com.business95.api.helper.RolHelper;
import com.business95.api.helper.SocioHelper;
import com.business95.api.helper.UsuarioHelper;
import com.business95.api.mapper.InversionMapper;
import com.business95.api.mapper.SocioMapper;
import com.business95.api.projection.BalanceSocioProjection;
import com.business95.api.repository.ActividadSocioRepository;
import com.business95.api.repository.InversionRepository;
import com.business95.api.repository.MovimientoRepository;
import com.business95.api.repository.SocioRepository;
import com.business95.api.security.context.SocioActual;
import com.business95.api.service.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    private final SocioRepository socioRepository;
    private final InversionRepository inversionRepository;
    private final MovimientoRepository movimientoRepository;
    private final ActividadSocioRepository actividadSocioRepository;
    private final SocioHelper socioHelper;
    private final UsuarioHelper usuarioHelper;
    private final RolHelper rolHelper;
    private final SocioMapper socioMapper;
    private final SocioActual socioActual;
    private final InversionMapper inversionMapper;
    private final PasswordEncoder passwordEncoder;

    public SocioServiceImpl(
            SocioRepository socioRepository,
            InversionRepository inversionRepository,
            MovimientoRepository movimientoRepository,
            ActividadSocioRepository actividadSocioRepository,
            SocioHelper socioHelper,
            UsuarioHelper usuarioHelper,
            RolHelper rolHelper,
            SocioMapper socioMapper,
            SocioActual socioActual,
            InversionMapper inversionMapper,
            PasswordEncoder passwordEncoder) {
        this.socioRepository = socioRepository;
        this.inversionRepository = inversionRepository;
        this.movimientoRepository = movimientoRepository;
        this.actividadSocioRepository = actividadSocioRepository;
        this.socioHelper = socioHelper;
        this.usuarioHelper = usuarioHelper;
        this.rolHelper = rolHelper;
        this.socioMapper = socioMapper;
        this.socioActual = socioActual;
        this.inversionMapper = inversionMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    @PreAuthorize("@catalogoSecurity.tienePermiso('REGISTRAR_SOCIOS')")
    public SocioResponse registrarSocio(RegistrarSocioRequest socioRequest) {

        Socio socio = socioHelper.construirSocio(
                null,
                socioRequest.getNombresRazonsocial(),
                socioRequest.getApellidos(),
                socioRequest.getTelefono(),
                socioRequest.getTipoPersona());

        Usuario usuario = usuarioHelper.construirUsuario(
                null,
                socioRequest.getCorreoElectronico(),
                socioRequest.getContrasena());

        socio.setUsuario(usuario);
        usuario.setSocio(socio);

        usuario.setRoles(Set.of(rolHelper.buscarPorRolOLanzarExcepcion("ROLE_USUARIO")));

        return socioMapper.toSocioResponseDTO(socioRepository.save(socio));
    }

    @Override
    @Transactional
    public SocioResponse actualizarSocio(ActualizarSocioRequest socioRequest) {

        Socio socio = socioHelper.construirSocio(
                socioActual.getIdSocioActual(),
                socioRequest.getNombresRazonsocial(),
                socioRequest.getApellidos(),
                socioRequest.getTelefono(),
                socioRequest.getTipoPersona());

        return socioMapper.toSocioResponseDTO(socioRepository.save(socio));
    }

    @Override
    @Transactional
    public void actualizarMiContrasena(ActualizarMiContrasenaRequest contrasenaRequest) {
        Socio socio = socioHelper.buscarPorIdOLanzarExcepcion(socioActual.getIdSocioActual());

        socio.getUsuario().setContrasena(passwordEncoder.encode(contrasenaRequest.getContrasena()));

        socioRepository.save(socio);
    }

    @Override
    @Transactional
    @PreAuthorize("@catalogoSecurity.tienePermiso('ACTUALIZAR_CONTRASENA')")
    public void actualizarContrasenaPorCorreo(ActualizarContrasenaPorCorreoRequest contrasenaPorCorreoRequest) {

        String correoElectronico = contrasenaPorCorreoRequest.getCorreoElectronico();
        String contrasena = contrasenaPorCorreoRequest.getContrasena();

        Socio socio = socioRepository.findByUsuarioCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new UsuarioNoEncontradoException());

        socio.getUsuario().setContrasena(passwordEncoder.encode(contrasena));

        socioRepository.save(socio);
    }

    @Override
    @Transactional(readOnly = true)
    public SocioResponse detalleSocio() {
        Long idSocio = socioActual.getIdSocioActual();
        return socioMapper.toSocioResponseDTO(socioHelper.buscarPorIdOLanzarExcepcion(idSocio));
    }

    @Override
    @Transactional(readOnly = true)
    public BalanceSocioResponse balanceSocio() {

        Long idSocio = socioActual.getIdSocioActual();

        BalanceSocioProjection socioProjection = socioRepository
                .balanceSocio(idSocio)
                .orElseThrow(() -> new SocioNoEncontradoException(idSocio));

        BalanceSocioResponse socioResponse = socioMapper.toBalanceSocioResponse(socioProjection);

        List<BalanceAnualSocioResponse> balances = socioRepository.balanceAnualSocio(idSocio)
                .stream()
                .map(socioMapper::toBalanceAnualSocioResponse)
                .toList();

        socioResponse.setHistorialAnual(balances);

        return socioResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InversionConBalancesSociosResponse> balanceInversionesPorSocio() {
        Long idSocio = socioActual.getIdSocioActual();

        return inversionRepository
                .balanceInversionPorIdSocioOIdInversion(idSocio, null)
                .stream()
                .map(inversionMapper::toBalanceInversionResponse)
                .toList();
    }

    @Override
    public Page<MovimientoRecienteResponse> movimientosRecientes(int pagina, int limite) {
        Long idSocio = socioActual.getIdSocioActual();
        Pageable pageable = PageRequest.of(pagina, limite);
        return movimientoRepository.movimientosRecientes(idSocio, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ActividadRecienteResponse> actividadesRecientes(int pagina, int limite) {
        Long idSocio = socioActual.getIdSocioActual();
        Pageable pageable = PageRequest.of(pagina, limite);
        return actividadSocioRepository.actividadesRecientes(idSocio, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public SocioNombresResponse nombresSocio(Long idSocio) {
        return socioMapper.toSocioNombresResponse(socioHelper.buscarPorIdOLanzarExcepcion(idSocio));
    }

}
