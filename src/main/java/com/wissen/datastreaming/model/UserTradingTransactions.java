package com.wissen.datastreaming.model;

public class UserTradingTransactions {
	
	    private String user;
	    private String securities;
	    private Integer currentPosition;
	    
		public UserTradingTransactions(String user, String securities, Integer currentPosition) {
			super();
			this.user = user;
			this.securities = securities;
			this.currentPosition = currentPosition;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getSecurities() {
			return securities;
		}

		public void setSecurities(String securities) {
			this.securities = securities;
		}

		public Integer getCurrentPosition() {
			return currentPosition;
		}

		public void setCurrentPosition(Integer currentPosition) {
			this.currentPosition = currentPosition;
		}

		@Override
		public String toString() {
			return "UserTradingTransactions [user=" + user + ", securities=" + securities + ", currentPosition="
					+ currentPosition + "]";
		}
	    
}
