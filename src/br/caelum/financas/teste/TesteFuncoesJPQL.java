package br.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.caelum.financas.dao.MovimentacaoDao;
import br.caelum.financas.modelo.Conta;
import br.caelum.financas.modelo.TipoMovimentaco;
import br.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaEtipo", Double.class);
		
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentaco.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		
		//MovimentacaoDao dao = new MovimentacaoDao(em);
		//List<Double> medias = dao.getMediasPorDiaEtipo(TipoMovimentaco.SAIDA, conta);
		
		for (Double media : medias) {
			System.out.println("A media é: " + media);
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
}
