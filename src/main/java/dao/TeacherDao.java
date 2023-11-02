package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.StudentGrade;
import dto.Teacher;

public class TeacherDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void save(Teacher teacher) {
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
	}


public Teacher fetchByEmail(String email) {
	List<Teacher> list = entityManager.createQuery("select c from Teacher c where email=?1").setParameter(1, email).getResultList();
	if(list.isEmpty()) {
		return null;
	}else {
		return list.get(0);
	}
}

public void save(StudentGrade grade) {
	entityTransaction.begin();
	entityManager.persist(grade);
	entityTransaction.commit();	
}
public List<StudentGrade> fetchAllTask() {
	return entityManager.createQuery("Select x from StudentGrade x").getResultList();
}
public void update(Teacher teacher) {
	entityTransaction.begin();
	entityManager.merge(teacher);
	entityTransaction.commit();	
}
}
