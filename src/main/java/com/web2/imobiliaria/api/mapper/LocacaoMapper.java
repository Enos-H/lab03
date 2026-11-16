package com.web2.imobiliaria.api.mapper;

import com.web2.imobiliaria.api.dto.input.LocacaoRequest;
import com.web2.imobiliaria.api.dto.output.LocacaoResponse;
import com.web2.imobiliaria.domain.model.Cliente;
import com.web2.imobiliaria.domain.model.Imovel;
import com.web2.imobiliaria.domain.model.Locacao;
import org.springframework.stereotype.Component;

@Component
public class LocacaoMapper {

    private final ImovelMapper imovelMapper;
    private final ClienteMapper clienteMapper;

    public LocacaoMapper(ImovelMapper imovelMapper, ClienteMapper clienteMapper) {
        this.imovelMapper = imovelMapper;
        this.clienteMapper = clienteMapper;
    }

    public Locacao paraEntidade(LocacaoRequest request, Imovel imovel, Cliente inquilino) {
        Locacao locacao = new Locacao();
        locacao.setAtivo(true);
        atualizarEntidade(locacao, request, imovel, inquilino);
        return locacao;
    }

    public void atualizarEntidade(Locacao locacao, LocacaoRequest request, Imovel imovel, Cliente inquilino) {
        locacao.setImovel(imovel);
        locacao.setInquilino(inquilino);
        locacao.setDataInicio(request.dataInicio());
        locacao.setDataFim(request.dataFim());
        locacao.setDiaVencimento(request.diaVencimento());
        locacao.setPercMulta(request.percMulta());
        locacao.setValorAluguel(request.valorAluguel());
        locacao.setObs(request.obs());
    }

    public LocacaoResponse paraResponse(Locacao locacao) {
        return new LocacaoResponse(
                locacao.getId(),
                imovelMapper.paraResumo(locacao.getImovel()),
                clienteMapper.paraResumo(locacao.getInquilino()),
                locacao.getAtivo(),
                locacao.getDataInicio(),
                locacao.getDataFim(),
                locacao.getDiaVencimento(),
                locacao.getPercMulta(),
                locacao.getValorAluguel(),
                locacao.getObs()
        );
    }
}
