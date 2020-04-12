function loadTradeData(){

    this.source = null;

    this.start = function () {

        var tradingDataTable = document.getElementById("data");

        this.source = new EventSource("/tradedata/stream");

        this.source.addEventListener("message", function (event) {

            // These events are JSON, so parsing and DOM fiddling are needed
            var userTradingTransaction = JSON.parse(event.data);

            var row = tradingDataTable.getElementsByTagName("tbody")[0].insertRow(0);
            var cell0 = row.insertCell(0);
            var cell1 = row.insertCell(1);
            var cell2 = row.insertCell(2);

            cell0.innerHTML = userTradingTransaction.user;

            cell1.innerHTML = userTradingTransaction.securities;

            cell2.innerHTML = userTradingTransaction.currentPosition;

        });

        this.source.onerror = function () {
            this.close();
        };

    };

    this.stop = function() {
        this.source.close();
    }

}

dataStream = new loadTradeData();

/*
 * Register callbacks for starting and stopping the SSE controller.
 */
window.onload = function() {
	dataStream.start();
};
window.onbeforeunload = function() {
	dataStream.stop();
}