package br.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.caelum.financas.modelo.Conta;
import br.caelum.financas.modelo.Movimentacao;
import br.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 1);
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
		
	}
	
}
