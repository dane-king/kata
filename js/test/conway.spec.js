describe('World', function() {
	var world;
	describe('initialized', function() {

		it('with no cells should be empty', function() {
			expect(new World().isEmpty()).toBe(true);
		});
		
		it('with rows and columns is not empty', function() {
			expect(new World(1,1).isEmpty()).toBe(false);
		});

		it('with invalid parameters is empty', function() {
			expect(new World(NaN,NaN).isEmpty()).toBe(true);
		});

		it('with string parameters is empty', function() {
			expect(new World("a",0).isEmpty()).toBe(true);
			expect(new World(0,"b").isEmpty()).toBe(true);
		});

		it('with empty cells should be empty', function() {
			expect(new World(0,0).isEmpty()).toBe(true);
		});

	});
});