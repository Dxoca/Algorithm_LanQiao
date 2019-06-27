QuickSort
  quickSort(A,p,r)
    if(p<r)
      q = partition(A,p,r)
      quickSort(A,p,q-1)
      quickSort(A,q+1,r)

  partition(A,p,r)
    pivot = A[p]
    sp = p+1  //扫描指针
    bigger = r //右侧指针
    while(sp<=bigger):
      if(A[sp]<=pivot)//扫描元素小于主元，左指针向右移
        sp++
      else
        swap(A,sp,bigger)//扫描元素大于主元，二指针的元素交换，右指针左移
        bigger--
    swap(A,p,bigger)
    return bigger


  partition2(A,p,r)
    pivot = A[p]
    left = p+1  //左侧指针
    right = r   //右侧指针
    while(left<=right){
      while(left<=right&&A[left]<=pivot)left++;//从左往右，遇到比主元大的元素，就停下来
      while(left<=right&&A[right]>pivot)right--;//从右往左，遇到小于等于主元的，就停下来
      // 这个时候，left一定指向大于主元的，right一定指向小于等于主元的
      if(left<right){
        swap(A,left,right);
      }
    }
    // 这个时候，left一定指向大于主元的，right一定指向小于等于主元的
    swap(A,p,right);
    return right;