# Denpasar - Jakarta

[![](https://mk0mitraissited2cion.kinstacdn.com/wp-content/uploads/2018/08/mitrais_teaser-670x300.jpg)](https://mk0mitraissited2cion.kinstacdn.com/wp-content/uploads/2018/08/mitrais_teaser-670x300.jpg)

## Subject of matter

| Subject | How To / Code | Time | Complexity Analysis
| ------ | ------ | ------ | ------ |
| Dummy Storage | [Demo](#dummy-storage)| 3 hrs | Normal
| Directed Acyclic Graph |  [Demo](#directed-acyclic-graph ) | 14 hrs | Hard
| Web Retail | [Demo](#web-retail) | 4hr | Easy

### Dummy Storage 
How to produce:
  - Create Class Solution from datastoreload package
  - Passing text to store(String) function to store items
  - Get array of String by calling load(String)
 
Ex:
#
    Solution s = new Solution();
    s.store("key\n1=value1;key2=value2;key3=value3\nkeyA=valueA");
	s.print();
Result:
#
    {key2=value2, key3=value3, key&1=&value1}
    {keyA=valueA}


### Directed Acyclic Graph 
How to produce:
  - Create Class DirectedGraph from acyclicgraph package
  - Add vertext using addVertex(Vertext) function
  - print() function capture the result 
 
Ex:
#
    DirectedGraph graph = new DirectedGraph();
	graph.addVertex(new Vertex("A", new Vertex("B"), 1));
	graph.addVertex(new Vertex("B", new Vertex("C"), 2));
	graph.addVertex(new Vertex("A", new Vertex("C"), 2));
    
    int result = graph.print();
Result:
#
    A(1) -> B(2) -> C(2), total = 5
    B(2) -> C(2), total = 4
    final result: 5

### Web Retail
How to produce:
  - Setup Employee Storage by inserting Employee
  - Setup User Storage by inserting User
  - Create Bill class from retailwebsite package
  - Add product to its bill
  - Call sum() function from bill to capture the total price
  - 
Ex:
#
    EmployeeStorage.instance().addNewEmployee(new Employee.Builder()
								.id(1)
								.name("User 1")
								.build());

    UserStorage.instance().addNewUser(new User.Builder()
                				.id(10)
                				.name("User 1")
                				.employeeId(1)
                				.build());
    
    Bill bill = new Bill(user);
	bill.addItem(new Item.Builder()
				.price(20f)
				.name("Note books")
				.build());
	bill.addItem(new Item.Builder()
				.price(10f)
				.name("Pen")
				.build());
	bill.addItem(new Item.Builder()
				.price(35f)
				.groceries(true)
				.name("Pizza")
				.build());
		
	float totalPrice = bill.sum();
	System.out.print(String.format("USD %.2f", totalPrice));
Result:
#
    USD 56.00


