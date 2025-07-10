class NumArray {

    int[] segTree;
    int n;
    // int[] nums;

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        if(n>0){
            buildTree(0,0,n-1,nums);
        }
    }

    public void buildTree(int i, int l, int r, int[] nums){          //node=i;
        if(l==r){
            segTree[i] = nums[l];
            return;
        }

        int mid = (l+r)/2;
        int leftT = (2*i)+1;
        int rightT = (2*i)+2;
        buildTree(leftT,l,mid,nums);
        buildTree(rightT,mid+1,r,nums);
        segTree[i] = segTree[leftT] + segTree[rightT];
    }
    
    public void update(int index, int val) {
        if(n>0){
            upd(0,0,n-1,val,index);
        }
    }

    public void upd(int i, int l, int r, int val, int idx){
        if(l==r){
            segTree[i]=val;
            return;
        }
        
        int mid=(l+r)/2;
        if(idx<=mid){
            upd(2*i+1,l,mid,val,idx);
        } else{
            upd(2*i+2,mid+1,r,val,idx);
        }
        segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }
    
    public int sumRange(int left, int right) {
        if(n==0) return 0;      
        return query(left,right,0,0,n-1);
    }

    public int query(int start, int end, int i, int l, int r){
        if(l>end || r<start) return 0;
        else if(l>=start && r<=end) return segTree[i];
        int mid = (l+r)/2;
        int leftT = query(start, end, 2*i+1, l, mid);
        int rightT = query(start, end, 2*i+2, mid+1, r);
        return leftT+rightT;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */