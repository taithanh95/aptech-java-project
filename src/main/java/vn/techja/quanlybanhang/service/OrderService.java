
package vn.techja.quanlybanhang.service;

import java.util.Date;
import java.util.List;
import vn.techja.quanlybanhang.entities.Order;
import vn.techja.quanlybanhang.entities.OrderItem;
import vn.techja.quanlybanhang.utilities.PaginatedResults;


public interface OrderService extends BaseService<Order> {

    Order findByCashierId(int id) throws Exception;

    public PaginatedResults<Order> todayOrder(int page) throws Exception;

    List<OrderItem> getOrderItems(Order order) throws Exception;

    PaginatedResults<Order> CashierStatistics(int page, Date fromDate, Date toDate) throws Exception;

    PaginatedResults<Order> findByCustomerPhone(int page, String phone) throws Exception;

    Order findByCustomerId(int id) throws Exception;

    PaginatedResults<Order> findByDateRange(Date fromDate, Date toDate, int page) throws Exception;

    String requestReportXlsx(Order order) throws Exception;
}