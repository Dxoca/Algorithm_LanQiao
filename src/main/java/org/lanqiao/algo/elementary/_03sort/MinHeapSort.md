MinHeap(A){
  n = A.length;
  for i from n/2-1 down to 0{
    MinHeapFixDown(A,i);
  }
}
MinHeapFixDown(A,i,n){
  // 找到左右孩子
  left = 2*i+1;
  right = 2*i+2;
  //左孩子已经越界，i就是叶子节点
  if(left>=n){
    return;
  }

  min = left;
  if(right>=n){
    min = left;
  }else{
    if(A[right]<A[left]){
      min = right;
    }
  }
  //min指向了左右孩子中较小的那个

  // 如果A[i]比两个孩子都要小，不用调整
  if(A[i]<=A[min]){
    return; 
  }
  //否则，找到两个孩子中较小的，和i交换
  temp = A[i];
  A[i] = A[min];
  A[min] = temp;
  //小孩子那个位置的值发生了变化，i变更为小孩子那个位置，递归调整
  MinHeapFixDown(A,min,n);
}

sort(A){
  //先对A进行堆化
  MinHeap(A);
  for(int x = n-1;x>=0;x--)
    //把堆顶，0号元素和最后一个元素对调
    swap(A,0,x);
    //缩小堆的范围，对堆顶元素进行向下调整
    MinHeapFixDown(A,0,x-1)
}