class CountNegatives {
    public int countNegatives(int[][] grid) {
        int negatives = 0 ;
        for(int []row:grid) {
            int start = 0 ;
            int end = row.length - 1 ;

            if(row[end] >= 0)
                continue;

            while(start < end){
                int mid = start + (end-start)/2;

                if (row[mid] >= 0) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            negatives += row.length - start;
        }

        return negatives;
    }
}
