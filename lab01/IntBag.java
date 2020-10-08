package lab01;

public class IntBag {
    private int[] bag;

    //Constructors

    public IntBag() {
        bag = new int [ 100 ];
        bag[0] = -1;
    }
    public IntBag( int MaxNumb ){
        bag = new int [ MaxNumb ];
        bag[0] = -1;
    }

    /**
     * remove method by looking index
     * @param i the index to be removed
     */
    public void remove( int i ) {

        bag[ i ] = bag[ size() - 1 ];
        bag[ size() - 1 ] = -1;

    }
    /**
     * add method by looking index , doubles the size when it is needed
     * @param elem
     */
    //adding a value
    public void add( int elem ) {
        int size = size();

        //case if bag is not full
        if (size < bag.length - 1) {
            bag[size] = elem;
            bag[ size + 1 ] = -1;
        }
        //case if bag is almost full
        else if ( size == bag.length - 1 ) {
            bag[ size ] = elem;
        }
        //case if bag is full, extends the bag
        else {
            int[] expander = new int[ size * 2 ];
            for ( int i = 0; i < bag.length; i++ ){
                expander[i] = bag[i];
            }
            bag = expander;
            bag[ size ] = elem;
            bag[ size + 1 ] = -1;

        }
    }
    /**
     * add method in a specific location
     * @param value to add
     * @param i the specific location -index-
     */
    // add a value to the end of the collection and to add a value at a particular index location i
    public void add(int value, int i ) {
        if ( i < size() ) {

            for (int j = bag.length - 2; j >= i; j--) {
                bag[j + 1] = bag[j];
            }
            bag[i] = value;
        }
    }

    public String toString() {

        StringBuilder str = new StringBuilder();
        boolean continueRepetition = true;

        for(int i = 0; i <= bag.length - 1 && continueRepetition ; i++) {

            if ( get(i) != -1 )
                str.append(bag[i]).append(" ");
            else
                continueRepetition = false;
        }
        return str.toString();
    }

    /**
     * remove a specific value from the bag.
     * @param removeValue value to be removed
     */
    public void removeAll ( int removeValue ){

        int count = 0;

        for( int j = 0; j < size(); ){
            if ( bag[j] == removeValue ){
                remove(j);
                count ++;
            }
            else
                j++;
        }
        if ( count == 0 )
            System.out.println("This number is not in the bag!");
    }

    // Size Method
    public int size() {

        int count = 0;
        boolean continueRepetition = true;

        while (count < bag.length && continueRepetition) {
            if (get(count) != -1)
                count++;
            else
                continueRepetition = false;
        }
        return count;
    }

    //getter

    public int get(int i) {
        
        return bag[i];
    }


}