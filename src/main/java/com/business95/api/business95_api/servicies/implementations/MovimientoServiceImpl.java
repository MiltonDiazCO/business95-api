package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.projections.MovimientoConsultaDTO;
import com.business95.api.business95_api.dtos.requests.ActividadSocioRequestDTO;
import com.business95.api.business95_api.dtos.requests.MovimientoRequestDTO;
import com.business95.api.business95_api.dtos.responses.ActividadSocioResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoResponseDTO;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
import com.business95.api.business95_api.repositories.CategoriaRepository;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.repositories.MedidaRepository;
import com.business95.api.business95_api.repositories.MonedaRepository;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.repositories.TipoActividadRepository;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

        @Autowired
        private MovimientoRepository movimientoRepository;

        @Autowired
        private InversionRepository inversionRepository;

        @Autowired
        private CategoriaRepository categoriaRepository;

        @Autowired
        private MonedaRepository monedaRepository;

        @Autowired
        private MedidaRepository medidaRepository;

        @Autowired
        private SocioRepository socioRepository;

        @Autowired
        private TipoActividadRepository tipoActividadRepository;

        @Override
        @Transactional(readOnly = true)
        public MovimientoResponseDTO findMovimientoDTOById(Long idMovimiento) {

                List<MovimientoConsultaDTO> movimientoConsultaDTO = movimientoRepository
                                .findMovimientoDTOById(idMovimiento);

                MovimientoResponseDTO movimientoResponseDTO = new MovimientoResponseDTO();

                movimientoResponseDTO.setIdMovimiento(movimientoConsultaDTO.get(0).getIdMovimiento());
                movimientoResponseDTO.setConcepto(movimientoConsultaDTO.get(0).getConcepto());
                movimientoResponseDTO.setCategoria(movimientoConsultaDTO.get(0).getCategoria());
                movimientoResponseDTO.setMoneda(movimientoConsultaDTO.get(0).getMoneda());
                movimientoResponseDTO.setMedida(movimientoConsultaDTO.get(0).getMedida());
                movimientoResponseDTO.setInversion(movimientoConsultaDTO.get(0).getInversion());

                for (MovimientoConsultaDTO actividadSocio : movimientoConsultaDTO) {
                        ActividadSocioResponseDTO actividadSocioResponseDTO = new ActividadSocioResponseDTO();
                        actividadSocioResponseDTO.setIdActividad(actividadSocio.getIdActividad());
                        actividadSocioResponseDTO.setSocio(actividadSocio.getSocio());
                        actividadSocioResponseDTO.setMonto(actividadSocio.getMonto());
                        actividadSocioResponseDTO.setCantidad(actividadSocio.getCantidad());
                        actividadSocioResponseDTO.setFecha(actividadSocio.getFecha());
                        actividadSocioResponseDTO.setTipoActividad(actividadSocio.getTipoActividad());
                        movimientoResponseDTO.addActividadSocio(actividadSocioResponseDTO);
                }

                return movimientoResponseDTO;
        }

        @Override
        @Transactional
        public MovimientoRequestDTO save(MovimientoRequestDTO movimientoRequestDTO) {

                Movimiento movimiento = new Movimiento();

                movimiento.setConcepto(movimientoRequestDTO.getConcepto());

                movimiento.setInversion(inversionRepository.findById(movimientoRequestDTO.getInversion())
                                .orElseThrow(() -> new InversionNoEncontradaException(
                                                movimientoRequestDTO.getInversion())));

                movimiento.setCategoria(categoriaRepository.findById(movimientoRequestDTO.getCategoria())
                                .orElseThrow(() -> new CategoriaNoEncontradaException(
                                                movimientoRequestDTO.getCategoria())));

                if (movimientoRequestDTO.getMoneda() != null) {
                        movimiento.setMoneda(monedaRepository.findById(movimientoRequestDTO.getMoneda())
                                        .orElseThrow(() -> new MonedaNoEncontradaException(
                                                        movimientoRequestDTO.getMoneda())));
                }

                if (movimientoRequestDTO.getMedida() != null) {
                        movimiento.setMedida(medidaRepository.findById(movimientoRequestDTO.getMedida())
                                        .orElseThrow(() -> new MedidaNoEncontradaException(
                                                        movimientoRequestDTO.getMedida())));
                }

                for (ActividadSocioRequestDTO actividadRequestDTO : movimientoRequestDTO
                                .getActividades()) {
                        ActividadSocio actividadSocio = new ActividadSocio();
                        actividadSocio.setMonto(actividadRequestDTO.getMonto());
                        actividadSocio.setCantidad(actividadRequestDTO.getCantidad());
                        actividadSocio.setFecha(actividadRequestDTO.getFecha());

                        actividadSocio.setSocio(socioRepository.findById(actividadRequestDTO.getSocio())
                                        .orElseThrow(() -> new SocioNoEncontradoException(
                                                        actividadRequestDTO.getSocio())));

                        actividadSocio.setTipoActividad(
                                        tipoActividadRepository.findById(actividadRequestDTO.getTipoActividad())
                                                        .orElseThrow(
                                                                        () -> new TipoActividadNoEncontradoException(
                                                                                        actividadRequestDTO
                                                                                                        .getTipoActividad())));

                        movimiento.addActividadSocio(actividadSocio);
                }

                movimientoRepository.save(movimiento);
                return movimientoRequestDTO;
        }

}
