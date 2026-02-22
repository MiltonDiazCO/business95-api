package com.business95.api.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.business95.api.dto.request.RegistrarSocioRequest;
import com.business95.api.dto.response.ActividadRecienteResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoRecienteResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.SocioResponse;

public interface SocioService {

    SocioResponse registrarSocio(RegistrarSocioRequest socioRequest);

    SocioResponse detalleSocio();

    BalanceSocioResponse balanceSocio();

    List<InversionConBalancesSociosResponse> balanceInversionesPorSocio();

    Page<MovimientoRecienteResponse> movimientosRecientes(int pagina, int limite);

    Page<ActividadRecienteResponse> actividadesRecientes(int pagina, int limite);

    SocioNombresResponse nombresSocio(Long idSocio);

}
