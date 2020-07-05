动态添加Fragment:
- 创建待添加的碎片实例
- 获取FragmentManager，在Activity中直接通过调用getSupportFragmentManager()方法得到
- 开启一个事务，通过调用beginTransaction()方法开启
- 向容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例
- 提交事务，调用commit()方法来完成

示例`com.zjn.helloworld/fragment/ContainerActivity`

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        aFragment = AFragment.newInstance("我是参数");
        mTvTitle = findViewById(R.id.tv_title);
        //把AFragment添加到Activity中,记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }
```
在碎片中模拟返回栈
- FragmentTransaction中提供了一个addToBackStack()方法，可以用于将一个事务添加到返回栈中

示例`com.zjn.helloworld/fragment/AFragment`

```java
mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();

                }

            }
        });
```
碎片的生命周期
- 运行状态：碎片可见，并且它所关联的活动正处于运行状态时，该碎片也处于运行状态
- 暂停状态：当一个活动进入暂停状态时（由于另一个未占满屏幕的活动被添加到了栈顶），与它相关联的可见碎片就会进入暂停状态。
- 停止状态：活动处于停止状态，或者通过调用FragmentTransaction的remove()\replace()；如果在事务提交之前调用addToBackStack()方法，碎片也会进入停止状态
- 销毁状态

附加回调方法
- onAttach()碎片和活动建立关联的时候调用
- onCreateView()为碎片创建视图（加载布局）时调用
- onActivityCreated()确保与碎片相关联的活动一定已经创建完毕时调用
- onDestroyView()当与碎片关联的视图被移除时候调用
- onDetach()碎片和活动解除关联时调用