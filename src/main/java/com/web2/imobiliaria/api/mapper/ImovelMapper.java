package com.web2.imobiliaria.api.mapper;

import com.web2.imobiliaria.api.dto.input.ImovelRequest;
import com.web2.imobiliaria.api.dto.output.ImovelResponse;
import com.web2.imobiliaria.api.dto.output.ImovelResumoResponse;
import com.web2.imobiliaria.domain.model.Imovel;
import org.springframework.stereotype.Component;

@Component
public class ImovelMapper {

    public Imovel paraEntidade(ImovelRequest request) {
        Imovel imovel = new Imovel();
        atualizarEntidade(imovel, request);
        return imovel;
    }

    public void atualizarEntidade(Imovel imovel, ImovelRequest request) {
        imovel.setTipoImovel(request.tipoImovel());
        imovel.setEndereco(request.endereco());
        imovel.setCep(request.cep());
        imovel.setDormitorios(request.dormitorios());
        imovel.setBanheiros(request.banheiros());
        imovel.setSuites(request.suites());
        imovel.setMetragem(request.metragem());
        imovel.setValorAluguelSug(request.valorAluguelSug());
        imovel.setObs(request.obs());
    }

    public ImovelResponse paraResponse(Imovel imovel) {
        return new ImovelResponse(
                imovel.getId(),
                imovel.getTipoImovel(),
                imovel.getEndereco(),
                imovel.getCep(),
                imovel.getDormitorios(),
                imovel.getBanheiros(),
                imovel.getSuites(),
                imovel.getMetragem(),
                imovel.getValorAluguelSug(),
                imovel.getObs()
        );
    }

    public ImovelResumoResponse paraResumo(Imovel imovel) {
        return new ImovelResumoResponse(
                imovel.getId(),
                imovel.getTipoImovel(),
                imovel.getEndereco()
        );
    }
}
