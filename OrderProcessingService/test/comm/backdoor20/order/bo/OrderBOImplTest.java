package comm.backdoor20.order.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.backdoor20.order.dao.OrderDAO;
import com.backdoor20.order.dto.Order;

import comm.backdoor20.order.exception.BOException;

class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	private OrderBOImpl bo;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	void placeOrder_Should_Create_An_Order() throws SQLException, BOException {		
		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao,times(1)).create(order);
	}

	
	@Test
	void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);
		assertFalse(result);
		verify(dao,atLeast(1)).create(order);

	}
	
	@Test
	void placeOrder_Should_Throw_BO_Exception() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		assertThrows(BOException.class, ()->bo.placeOrder(order));

	}
	
	
	@Test
	public void cancelOrder_Should_Cancel_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(123);		
		assertTrue(result);
		verify(dao).read(123);
		verify(dao).update(order);
		
	}
	
	@Test
	public void cancelOrder_Should_Not_Cancel_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result = bo.cancelOrder(123);		
		assertFalse(result);
		verify(dao).read(123);
		verify(dao).update(order);
		
	}
	
	@Test
	public void cancelOrder_Should_Throw_Exception_Read() throws SQLException, BOException {
		
		when(dao.read(123)).thenThrow(SQLException.class);
		assertThrows(BOException.class, ()->bo.cancelOrder(123));
	}
	
	
	@Test
	public void cancelOrder_Should_Throw_Exception_Update() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		assertThrows(BOException.class,()-> bo.cancelOrder(123));		
		
		
	}
	
	@Test
	public void deleteOrder_Delete_The_order() throws BOException, SQLException {
		when(dao.delete(123)).thenReturn(1);
		boolean result=bo.deleteOrder(123);
		assertTrue(result);
		verify(dao).delete(123);
	}
	
	@Test
	public void deleteOrder_Not_Delete_The_Order() throws BOException, SQLException {
		when(dao.delete(123)).thenReturn(0);
		boolean result=bo.deleteOrder(123);
		assertFalse(result);
		verify(dao).delete(123);
	}
	
	@Test
	public void deleteOrder_Delete_Throw_Exception() throws BOException, SQLException {
		when(dao.delete(anyInt())).thenThrow(SQLException.class);
		assertThrows(BOException.class, ()->bo.deleteOrder(123));
	}
	
	@Test
	public void getDAO_Test() {
		OrderDAO dao2 = bo.getDao();
		assertEquals(dao, dao2);
	}
}
