```
MergerSort
  mergeSort(A,p,r){
    if(p<r){
      mid = p+((r-p)>>1);
      mergeSort(A,p,mid);
      mergeSort(A,mid+1,r);
      merge(A,p,mid,r);
    }
  }
  helper = [A.length];
  merge(A,p,mid,r){
    //先把A中的数据拷贝到helper中
    copy(A,p,helper,p,r-p+1);
    left=p//左侧队伍的头部指针，指向待比较的元素
    right=mid+1//右侧队伍的头部指针，指向待比较的元素
    current = p //原数组的指针，指向待填入数据的位置

    while(left<=mid&&right<=r){
      if(helper[left]<=helper[right]){
        A[current] = helper[left];
        current++;
        left++;
      }else{
        A[current] = helper[right];
        current++;
        right++;
      }
    }

    while(left<=mid){
      A[current] = helper[left];
      current++;
      left++;
    }
  }
```