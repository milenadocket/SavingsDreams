package controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.List;

import model.Movimentacao;
import model.Poupanca;
import model.TipoMovimentacao;
import persistence.DAO;
import persistence.PoupancaDAO;

public class PoupancaController extends Controller<Poupanca> {

	public Poupanca buscarUltimo() {
		dao = new PoupancaDAO();
		return dao.getLast();
	}

	@Override
	public Poupanca salvar(Poupanca poupanca) {
		dao = new PoupancaDAO();
		return dao.salvar(poupanca);
	}

	@Override
	public Poupanca alterar(Poupanca poupanca) {
		dao = new PoupancaDAO();
		return dao.alterar(poupanca);
	}

	@Override
	public Boolean deletar(Poupanca t) {
		return null;
	}

	@Override
	public List<Poupanca> listar() {
		return null;
	}

	@Override
	public Poupanca buscarPorId(Integer id) {
		dao = new PoupancaDAO();
		return dao.getById(id);
	}
	
	public Poupanca atualizarValor(Poupanca poupanca, Movimentacao movimentacao) {
		if(movimentacao.getTipo().equals(TipoMovimentacao.ENTRADA)) {
			poupanca.setSaldo(poupanca.getSaldo().add(movimentacao.getValor()));
		} else {
			poupanca.setSaldo(poupanca.getSaldo().subtract(movimentacao.getValor()));
		}
		
		poupanca.setUltimaAtualizacao(LocalDateTime.now());
		
		return poupanca;
	}
	
	public BigDecimal getSaldo() {
		dao = new PoupancaDAO();
		return dao.getLast().getSaldo();
	}


}
