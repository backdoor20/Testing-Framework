package comm.backdoor20.order.bo;

import com.backdoor20.order.dto.Order;

import comm.backdoor20.order.exception.BOException;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;
}
