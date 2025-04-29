package Utility;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO {

		private Long orderId;
	    private Long userId;
	    private String itemName;
	    private String status;
	    @JsonFormat(pattern = "dd-MM-yyyy")
	    private LocalDate orderDate;
	    
		public OrderDTO() {
			super();
		}

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
		
	    
	

}
