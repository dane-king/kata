function World(rows, columns) {
	var _this = this;
	this.cells = new Cells(rows,columns);

	this.hasCells = function() {
		return _this.cells.rows!==0 || _this.cells.rows!==0;
	};

	this.isEmpty = function() {
		return !_this.hasCells();
	};
}

function Cells(rows, columns) {
	var getValidNumber=function(num){
		return Number.isInteger(rows)?rows:0;	
	};
	this.rows = getValidNumber(rows);
	this.columns = getValidNumber(columns);
}