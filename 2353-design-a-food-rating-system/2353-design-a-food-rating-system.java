class FoodRatings {
    class Node{
        String food;
        String cuisine;
        int rating;

        Node(String f, String c, int r){
            this.food = f;
            this.cuisine = c;
            this.rating = r;
        }
    }
    Map<String, PriorityQueue<Node>> mpp1 = new HashMap<>();
    Map<String, Node> mpp2 = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0; i < n; i++){
            Node newNode = new Node(foods[i], cuisines[i], ratings[i]);
            mpp2.put(foods[i], newNode);
            mpp1.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((a,b) -> {
                if(a.rating != b.rating) return Integer.compare(b.rating, a.rating);
                else return a.food.compareTo(b.food);
            })).add(newNode);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Node current = mpp2.get(food);
        Node newNode = new Node(food, current.cuisine, newRating);
        mpp2.put(food, newNode);
        mpp1.get(current.cuisine).add(newNode);
    }
    
    public String highestRated(String cuisine) {
       PriorityQueue<Node> pq = mpp1.get(cuisine);

        // 2. Loop with peek() instead of poll() so valid items stay in the queue
        while (!pq.isEmpty()) {
            Node highest = pq.peek();
            Node actual = mpp2.get(highest.food);

            if (highest.rating == actual.rating) {
                return highest.food;
            }
            
            // Stale entry: remove it and inspect the next one
            pq.poll();
        }

        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */