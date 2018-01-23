package br.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.caelum.financas.modelo.Conta;
import br.caelum.financas.modelo.TipoMovimentaco;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaEtipo(TipoMovimentaco saida, Conta conta) {
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo"
				+ " group by m.data";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentaco.SAIDA);

		List<Double> medias = query.getResultList();
		return medias;
	}

}
