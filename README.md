# SwipeMenuRecyclerView

�����ǻ���RecyclerView�ķ�װ��

> **ע��**��������1.1.0������ȫ��������û����1.0.x�汾�����¼��ݣ������°���APIʹ�ú͹��ܷ��涼�Ǹ�ȫ�µ�������ʹ�þɰ汾��ͬѧ����ʱ��Ҫ��ReadMe��Demo���濴һ�顣
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/a.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/b.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/c.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/d.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/e.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/q.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/w.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/x.jpg)
![](https://github.com/yufeilong92/SwipeMenuRecyclerView/tree/master/img/z.jpg)
# ����
1. ����`List/Grid/StaggeredGrid`��`LayoutManager`��`Item`�໬�˵���
2. `Item`����໬�˵�֧��ˮƽ�ֲ�����ֱ�ֲ���
3. `Item`��ק���򡢲໬ɾ����
4. ��ʱ��ӻ����Ƴ�`HeaderView`��`FooterView`��
5. �ṩ**�Զ�/���**���ظ���Ĺ��ܡ�[[Ϊʲôû������ˢ�£�](http://blog.csdn.net/yanzhenjie1003/article/details/75949335)][[ListView��GridView��ô�죿](https://github.com/yanzhenjie/LoadMore)]
6. ��`SwipeMenuLayout`���κεط�������ʵ�����Լ��Ĳ໬�˵���
7. ��`ViewPager`��`DrawerLayout`�Ȼ�������Ƕ��ʹ�á�
8. `Sticky`��ͨ���������`ReyclerView`���������

> **ע��**��ʹ�ñ���ֻ��Ҫʹ��`SwipeMenuRecyclerView`���ɣ�����ʹ���κε�������Adapter������`BaseRecyclerViewAdapterHelper`��

# ��ͼ
�������ᵽ��Ч����������ʾ��������ȫ��������Ч����������Demo�鿴��

## Item�໬�˵�
<image src="./image/1.gif" width="180px"/> <image src="./image/2.gif" width="180px"/> <image src="./image/3.gif" width="180px"/>

## Item�໬ɾ������ק
<image src="./image/4.gif" width="180px"/> <image src="./image/5.gif" width="180px"/> <image src="./image/6.gif" width="180px"/>

## ����ˢ�ºͼ��ظ���
<image src="./image/7.gif" width="180px"/>

## HeaderView��FooterView
<image src="./image/8.gif" width="180px"/>

## StickyЧ����Item����
<image src="./image/9.gif" width="180px"/>  <image src="./image/10.gif" width="180px"/>

## ��DrawerLayoutǶ��
<image src="./image/11.gif" width="180px"/>

# ���ʹ��
��������`SwipeRecyclerView`�������Ŀ�У�Ȼ��Ϳ��Խ��п��������ˡ�

## ����
* Gradle
```groovy
compile 'com.yanzhenjie:recyclerview-swipe:1.1.3'
```

* Maven
```xml
<dependency>
  <groupId>com.yanzhenjie</groupId>
  <artifactId>recyclerview-swipe</artifactId>
  <version>1.1.3</version>
  <type>pom</type>
</dependency>
```

## ����
��xml������SwipeRecyclerView��
```xml
<com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView
    .../>
```

**ע��**��
1. �°��1.1.0��ʼ������Ҫ�̳�`SwipeMenuAdapter`�ˣ�ֻ��Ҫʹ��`SwipeMenuRecyclerView`���ɡ�
2. ��������`HeaderView`������ͨ��`ViewHolder`�õ���`position`��Ҫ����`HeaderView`���������ܵõ���ȷ��`item position`��

### ItemDecoration
Ҳ���Ƿָ��ߣ�֧��Grid��ʽ��Linear��ʽ������ѡ��ĳ��ViewType�����ָ��ߣ�
```java
// Ĭ�Ϲ��죬������ɫ���ɡ�
new DefaultDecoration(color);

// ��ɫ�����ߣ����һ�������ǲ����ָ��ߵ�ViewType�����Դ�������
new DefaultDecoration(color, width, height, excludeViewType);

// ���������123���ǲ����ָ��ߵ�ViewType��
new DefaultDecoration(color, width, height, 1, 2, 3);
```

### Item�������
```
recyclerView.setSwipeItemClickListener(new SwipeItemClickListener() {
    @Override
    public void onItemClick(View view, int position) {
        // TODO��������...
    }
});
```

### �໬�˵�
```java
// ���ü�������
swipeRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);

// �����˵���
SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
    @Override
    public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
        SwipeMenuItem deleteItem = new SwipeMenuItem(mContext)
            ...; // �������ֺ�ͼ���������á�
        leftMenu.addMenuItem(deleteItem); // ��Item������һ���˵���

        SwipeMenuItem deleteItem = new SwipeMenuItem(mContext)
            ...; // �������ֺ�ͼ���������á�
        leftMenu.addMenuItem(deleteItem); // ��Item�Ҳ����һ���˵���
        
        // ע�⣺�ı߲���Ҫ�˵�����ô��Ҫ��Ӽ��ɡ�
    }
};

// �˵����������
swipeRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);

SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
    @Override
    public void onItemClick(SwipeMenuBridge menuBridge) {
        // �κβ��������ȹرղ˵���������ܳ���Item�˵���״̬���ҡ�
        menuBridge.closeMenu();
        
        int direction = menuBridge.getDirection(); // ��໹���Ҳ�˵���
        int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView��Item��position��
        int menuPosition = menuBridge.getPosition(); // �˵���RecyclerView��Item�е�Position��
    }
};
```

**ע��**���˵���Ҫ���ø߶ȣ����ڲ˵��߶ȣ�
1. `MATCH_PARENT`���Զ���ӦItem�߶ȣ����ֺ�Itemһ���ߣ��Ƚ��Ƽ�;
2. ָ������ĸߣ�����80;
3. `WRAP_CONTENT`������߶ȣ������Ƽ�;

### �໬ɾ������ק
��ק�Ͳ໬ɾ���Ĺ���Ĭ�Ϲرյģ�������Ҫ�򿪹��ܣ�
```java
recyclerView.setLongPressDragEnabled(true); // ��ק����Ĭ�Ϲرա�
recyclerView.setItemViewSwipeEnabled(true); // �߻�ɾ����Ĭ�Ϲرա�
```

ֻ��Ҫ���������������ԾͿ��Խ�����Ӧ�Ķ����ˣ��������Ҫ�ĸ�����Ҫ�򿪾Ϳ����ˡ�

Ȼ�������ק�Ͳ໬�Ķ������������ݸ��£�
```java
recyclerView.setOnItemMoveListener(mItemMoveListener);// ������ק������UI��

OnItemMoveListener mItemMoveListener = new OnItemMoveListener() {
    @Override
    public boolean onItemMove(ViewHolder srcHolder, ViewHolder targetHolder) {
        int fromPosition = srcHolder.getAdapterPosition();
        int toPosition = targetHolder.getAdapterPosition();
        
        // Item����קʱ���������ݣ�������adapter��
        Collections.swap(mDataList, fromPosition, toPosition);
        adapter.notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(ViewHolder srcHolder) {
        int position = srcHolder.getAdapterPosition();
        // Item���໬ɾ��ʱ��ɾ�����ݣ�������adapter��
        mDataList.remove(position);
        adapter.notifyItemRemoved(position);
    }
};
```

**�ر�ע��**�����`LayoutManager`��`List`��ʽ����ôItem��קʱֻ�ܴ�1-2-3-4�����ߣ�������`LayoutManager`��`Grid`��ʽ�ģ���ôItem���Դ�1ֱ�ӵ�3����5����6...���������ݾͻ���ң�����**��`LayoutManager`��Grid��ʽʱ**����Ҫ�ر�ע��ת������λ�õ��㷨��
```java
@Override
public boolean onItemMove(ViewHolder srcHolder, ViewHolder targetHolder) {
    int fromPosition = srcHolder.getAdapterPosition();
    int toPosition = targetHolder.getAdapterPosition();
    if (fromPosition < toPosition)
        for (int i = fromPosition; i < toPosition; i++)
            Collections.swap(mDataList, i, i + 1);
    else
        for (int i = fromPosition; i > toPosition; i--)
            Collections.swap(mDataList, i, i - 1);

    mMenuAdapter.notifyItemMoved(fromPosition, toPosition);
    return true;
}
```

���ǻ����Լ����û��Ĳ໬ɾ������קItemʱ����ָ״̬��
```java
recyclerView.setOnItemStateChangedListener(mStateChangedListener);

...

private OnItemStateChangedListener mStateChangedListener = (viewHolder, actionState) -> {
    if (actionState == OnItemStateChangedListener.ACTION_STATE_DRAG) {
        // ״̬��������ק��
    } else if (actionState == OnItemStateChangedListener.ACTION_STATE_SWIPE) {
        // ״̬������ɾ����
    } else if (actionState == OnItemStateChangedListener.ACTION_STATE_IDLE) {
        // ״̬����ָ�ɿ���
    }
};
```

���û�������ĳ��`Item`ʱ�Ϳ�ʼ��ק���߲໬ɾ��ʱ��ֻ��Ҫ����`startDrag()`��`startSwipe()`��ת�뵱ǰ`Item`��`ViewHoler`���ɡ�

������ק��
```java
swipeRecyclerView.startDrag(ViewHolder);
```

�����໬ɾ����
```java
swipeRecyclerView.startSwipe(ViewHolder);
```

### HeaderView��FooterView
��Ҫ������
```java
addHeaderView(View); // ���HeaderView��
removeHeaderView(View); // �Ƴ�HeaderView��
addFooterView(View); // ���FooterView��
removeFooterView(View); // �Ƴ�FooterView��
getHeaderItemCount(); // ��ȡHeaderView������
getFooterItemCount(); // ��ȡFooterView������
getItemViewType(int); // ��ȡItem��ViewType������HeaderView��FooterView����ͨItemView��
```
���/�Ƴ�HeaderView/FooterView��setAdapter()�ĵ��ò����Ⱥ�˳��

**�ر�ע��**��
1. ��������`HeaderView`������ͨ��`ViewHolder`�õ���`position`��Ҫ����`HeaderView`���������ܵõ���ȷ��`item position`��

### ���ظ���
����Ĭ���ṩ�˼��ظ���Ķ�����View��������Ҳ�����Զ��壻Ĭ��֧��`RecyclerView`�Դ������ֲ��ֹ�������

Ĭ�ϼ��ظ��ࣺ
```java
RecyclerView recyclerView = ...��
...

recyclerView.useDefaultLoadMore(); // ʹ��Ĭ�ϵļ��ظ����View��
recyclerView.setLoadMoreListener(mLoadMoreListener); // ���ظ���ļ�����

LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
    @Override
    public void onLoadMore() {
        // �ü��ظ�������
        
        ... // �������ݣ�����������Դ������
        mMainAdapter.notifyDataSetChanged();

        // ������������ݣ�һ��Ҫ�������������
        // ��һ����������ʾ�˴������Ƿ�Ϊ�ա�
        // �ڶ�����������ʾ�Ƿ��и������ݡ�
        mRecyclerView.loadMoreFinish(false, true);

        // �������ʧ�ܵ�������ķ���������errorCode��errorMessage��
        // errorCode��㴫�����Զ���LoadMoreViewʱ���Ը���errorCode�жϴ������͡�
        // errorMessage�ǻ���ʾ��loadMoreView�ϵģ��û����Կ�����
        // mRecyclerView.loadMoreError(0, "��������ʧ��");
    }
};
```

�Զ�����ظ���ViewҲ�ܼ򵥣��Զ���һ��View����ʵ��һ���ӿڼ��ɣ�
```java
public class DefineLoadMoreView extends LinearLayout
        implements SwipeMenuRecyclerView.LoadMoreView,
        View.OnClickListener {

    private LoadMoreListener mLoadMoreListener;

    public DefineLoadMoreView(Context context) {
        super(context);
        ...
        setOnClickListener(this);
    }

    /**
     * ���Ͽ�ʼ�ص����ظ����ˣ�����Ӧ����ʾ��������
     */
    @Override
    public void onLoading() {
        // չʾ���ظ���Ķ�������ʾ��Ϣ��
        ...
    }

    /**
     * ���ظ�������ˡ�
     *
     * @param dataEmpty �Ƿ����󵽿����ݡ�
     * @param hasMore   �Ƿ��и������ݵȴ�����
     */
    @Override
    public void onLoadFinish(boolean dataEmpty, boolean hasMore) {
        // ���ݲ�������ʾû�����ݵ���ʾ��û�и������ݵ���ʾ��
        // ����������ڣ��򶼲�����ʾ��
    }

    /**
     * ���س�����������Ĵ�����ʹ�����Ϣ��ѡһ��
     *
     * @param errorCode    �����롣
     * @param errorMessage ������Ϣ��
     */
    @Override
    public void onLoadError(int errorCode, String errorMessage) {
    }

    /**
     * ������setAutoLoadMore(false)������Ҫ���ظ����ʱ�򣬴˷��������ã�������listener��
     */
    @Override
    public void onWaitToLoadMore(SwipeMenuRecyclerView.LoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
        }

    /**
     * ���Զ����ظ���ʱmLoadMoreListener�Ų�Ϊ�ա�
     */
    @Override
    public void onClick(View v) {
        if (mLoadMoreListener != null) mLoadMoreListener.onLoadMore();
    }
}
```

# ����
```
-keepclasseswithmembers class android.support.v7.widget.RecyclerView$ViewHolder {
   public final View *;
}
```
�����඼�ǿ��Ի����ģ�������������������Ǵ������⣬��ô��׷�ӣ�
```
-dontwarn com.yanzhenjie.recyclerview.swipe.**
-keep class com.yanzhenjie.recyclerview.swipe.** {*;}
```