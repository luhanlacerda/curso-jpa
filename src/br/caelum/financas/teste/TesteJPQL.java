package br.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.caelum.financas.modelo.Conta;
import br.caelum.financas.modelo.Movimentacao;
import br.caelum.financas.modelo.TipoMovimentaco;
import br.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo"
				+ " order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentaco.SAIDA);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Conda.id: " + movimentacao.getConta().getId());
		}

		em.getTransaction().commit();
		em.close();

	}

}
