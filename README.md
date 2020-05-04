# DateTimePicker
一个可以选择时间和日期的工具类。  
# 如何引用
* Gradle
```java
dependencies {
    implementation 'com.github.hanjie511:DateTimePicker:1.0.0'
	}
```
* maven
```java
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
      </repository>
      </repositories>
  <dependency>
      <groupId>com.github.hanjie511</groupId>
      <artifactId>DateTimePicker</artifactId>
      <version>1.0.0</version>
  </dependency>
  ```  
  # 在项目中如何引用
  ```java
  /**
     *
     * @param context
     * @param showType
     *     public static final int showYearAndMonth;//隐藏时间选择只显示日期选择（只显示日期选择对话框中的年份和月份）
     *     public static final int showMonthAndDay;//隐藏时间选择只显示日期选择（只显示日期选择对话框中的月份和号数）
     *     public static final int justShowDatePicker;//隐藏时间选择,只显示日期
     *     public static final int justShowTimePicker;//隐藏日期选择，只显示时间
     *     public static final int showAll;//时间和日期均可显示和选择
     */
  DateTimePickerDialog dateTimePickerDialog=new DateTimePickerDialog(Context context,int showType);//实例化DateTimePickerDialog对象
  dateTimePickerDialog.setOnSetDateTimeChangeListener(new DateTimePickerDialog.SetDateTimeChangeListener() {//设置时间和日期变化的监听
        @Override
       public void setDateTime(DatePicker datePicker, TimePicker timePicker, int year, int month, int day, int hour, int minute) {
                //在这里处理返回的日期和时间的结果
            }
        });
``` 
# 节目效果
![展示效果](https://github.com/hanjie511/DateTimePicker/blob/master/SVID_20200504_175016_1.gif)

  
