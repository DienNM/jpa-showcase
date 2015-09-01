package com.dee.jpa.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import com.dee.jpa.hibernate.impl.EmployeeServiceImpl;
import com.dee.jpa.hibernate.model.Address;
import com.dee.jpa.hibernate.model.Department;
import com.dee.jpa.hibernate.model.Employee;
import com.dee.jpa.hibernate.model.Phone;

/**
 * @author dien.nguyen
 **/

public class EmployeeServiceTest extends TestCase {
    
    private EmployeeService employeeService;
    
    private List<Employee> employees = new ArrayList<Employee>();
    private EntityManager em = EntityManagerUtil.getEntityManager();
    
    @Override
    protected void setUp() throws Exception {
        
        employeeService = new EmployeeServiceImpl(em);
        initData();
    }
    
    @Override
    protected void tearDown() throws Exception {
        em.getTransaction().begin();
        
        em.createQuery("DELETE FROM Employee").executeUpdate();
        em.createQuery("DELETE FROM Address").executeUpdate();
        em.createQuery("DELETE FROM Department").executeUpdate();
        em.createQuery("DELETE FROM Phone").executeUpdate();
        
        em.getTransaction().commit();
        em.close();
    }
    
    private void initData() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        // Department
        Department department1 = new Department("HR");
        Department department2 = new Department("IT");
        em.persist(department1);
        em.persist(department2);
        
        
        Employee employee1 = new Employee();
        employee1.setEmail("email1@gmail.com");
        employee1.getPhones().add(new Phone("0988xxxxxx"));
        employee1.getPhones().add(new Phone("0982xxxxxx"));
        employee1.getPhones().add(new Phone("0981xxxxxx"));
        employee1.getPhones().add(new Phone("0983xxxxxx"));
        employee1.setDept(department1);
        employee1.setAddress(new Address("Ca Mau"));
        
        Employee employee2 = new Employee();
        employee2.setEmail("email2@gmail.com");
        employee2.getPhones().add(new Phone("0823xxxxxx"));
        employee2.getPhones().add(new Phone("0826xxxxxx"));
        employee2.getPhones().add(new Phone("0829xxxxxx"));
        employee2.setDept(department1);
        employee2.setAddress(new Address("Ho Chi Minh"));
        
        Employee employee3 = new Employee();
        employee3.setEmail("email3@gmail.com");
        employee3.getPhones().add(new Phone("0788xxxxxx"));
        employee3.getPhones().add(new Phone("0766xxxxxx"));
        employee3.setDept(department2);
        employee3.setAddress(new Address("Da Lat"));
        
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void testGetAll() {
        
        List<Employee> employees = employeeService.getAll();
        assertEquals(3, employees.size());
        
    }
    
    public void testGetByEmail() {
        
        Employee employee = employeeService.getByEmail("email3@gmail.com");
        assertNotNull(employee);
        assertEquals("email3@gmail.com", employee.getEmail());
        assertEquals("IT", employee.getDept().getName());
        assertEquals("Da Lat", employee.getAddress().getAddress());
        
        employee = employeeService.getByEmail("not-found@gmail.com");
        assertNull(employee);
        
    }
    
    public void testGetByDeptName() {
        
        List<Employee> employees = employeeService.getByDepartmentName("IT");
        assertNotNull(employees);
        assertEquals(1, employees.size());
        
        
        employees = employeeService.getByDepartmentName("HR");
        assertNotNull(employees);
        assertEquals(2, employees.size());
        
    }
    
    public void testGetByPhone() {
        
        Employee employee = employeeService.getByPhoneNumber("0988xxxxxx");
        assertNotNull(employee);
        assertEquals("email1@gmail.com", employee.getEmail());
        
        employee = employeeService.getByPhoneNumber("0829xxxxxx");
        assertNotNull(employee);
        assertEquals("email2@gmail.com", employee.getEmail());
        
    }
    
    public void testGetPhones() {
        
        List<Phone> phones = employeeService.getPhones(employees.get(0).getId());
        assertEquals(4, phones.size());
        assertEquals("0988xxxxxx", phones.get(0).getNum());
        
    }
    
    public void testGetAddress() {
        
        Address address = employeeService.getAddress(employees.get(0).getId());
        assertNotNull(address);
        
    }
    
    public void testGetEmployeeEmail() {
        
        String email = employeeService.getEmployeeEmail(employees.get(0).getId());
        assertEquals("email1@gmail.com", email);
        
    }
    
    public void testGetPhoneNums() {
        
        List<String> phoneNums = employeeService.getPhoneNumbers(employees.get(0).getId());
        assertEquals(4, phoneNums.size());
        
    }
    
    public void testGetEmailAndPhoneNums() {
        
        List<String> emailAndPhone = employeeService.getEmailAndPhoneNumbers(employees.get(0).getId());
        assertEquals(4, emailAndPhone.size());
        
    }
}
