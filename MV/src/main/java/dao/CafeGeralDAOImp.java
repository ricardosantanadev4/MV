package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JpaUtil;

public class CafeGeralDAOImp implements CafeGeralDAO {

	@Override
	public void linha() {
		for (int i = 0; i < 129; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}

	@Override
	public void top() {
		linha();
		for (int i = 0; i < 60; i++) {
			if (i == 0) {
				System.out.print("|");
			} else if (i == 30) {
				System.out.print(" BEM VINDO! A TELA DE CADASTRO DE PARTICIPANTES PARA O CAFÉ DA MANHÃ! ");
			} else if (i == 59) {
				System.out.print("|\n");
			} else {
				System.out.print("*");
			}
		}
		linha();
	}

	public void inserir(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.persist(obj);
		tx.commit();
		ent.close();
		System.out.println("Opção de café da manhã cadastrada com sucesso!");
	}

	public List buscarTodos(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery(" from " + obj.getClass().getSimpleName());
		return query.getResultList();
	}

	public void remover(Class classe, Object primaryKey) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		Object obj = ent.find(classe, primaryKey);
		ent.remove(obj);
		tx.commit();
		ent.close();
		System.out.println("Participante Removido da Lista de Partipantes do Café da Manhã!");
	}

	@Override
	public Object buscarEspecifico(Class classe, Object primaryKey) {
		EntityManager ent = JpaUtil.getEntityManager();
		return ent.find(classe, primaryKey);
	}

	@Override
	public void atualizar(Object obj) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.merge(obj);
		tx.commit();
		ent.close();
		System.out.println("Atualização efetuada com sucesso!");		
	}


	

}
