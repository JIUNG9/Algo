class StockSpanner {
    //연속적으로 이전에 있는 것들이 현재 확인하는 값 보다 작은 것의 자신을 포함한 것의 개수 -> 즉 무조건 순서대로 있어야한다. + 기록을 하자. 100에는 100보다 작은 것이 몇 개 있는지, 80 이전에는 80보다 작은 것이 몇 개 있는지, 60 이전에는 60보다 작은 것이 몇 개 있는지 즉 70을 확인할 때 60을 확인한다. 자신보다 작은 값들이 이전에 몇 개 존재했는지 파악, 만약 자신보다 큰 것이 존재한다면 거기서 끝
    //main stack을 생성하고 temp stack를 작성하지만, 다른 heap주소를 가져야한다. 이전의 것들을 항상 복원해야한다 -> addAll을 사용하면 n^2 시간복잡도
    //stack에 자신보다 작은 것들이 몇 개 존재하는지를 함께 기록한다. [100, 1] / [80, 1] / [60 , 1]/ [70,2] 이런 구조라면 [60,1] 은 스택에 존재하지 않는다. 하지만 이전에 자신보다 작은 것이 하나 더 있다는 것을 알 수 있다. 60이라는 값 자체에는 의미가 없기 때문에 가능하다. 즉 현재 검사한느 원소보다 작은 값을 만날 때까지 그 값을 더하고, 해당 값을 나의 두 번째 idx에 추가하여 스택에 저장한다.x
    
    //100 80 60 70
    Stack<Stock> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        //peek한 값이 더 작다면 해당 값을 pop한 이후에 totalSpan에 지속적으로 더한다. 더 이상 피크할 수 없다면 해당 totalSpan을 현재 stack에 저장한다.
        int totalSpan = 1;
        while (!stk.isEmpty() && stk.peek().price <= price){
            Stock prevStock = stk.pop();
            totalSpan+=prevStock.span;
        } 
        stk.push(new Stock(price,totalSpan));
        return totalSpan;
    }
    class Stock{
        private int price;
        private int span;

        public Stock(int price, int span){
            this.price = price;
            this.span = span;
        }
    }
}

