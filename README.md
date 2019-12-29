# LiveData + DataBinding
## Implement ViewModel and DataBinding
Open build.gradle (Module: App) and add this line of code

      apply plugin: 'com.android.application'
      
      android {
          ....
          // Enabled DataBinding
          dataBinding{
              enabled = true
          }
      }

      dependencies {
          ...
          // For ViewModel Implementation
          implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
          
          // For FloatingActionButton Implementation
          // You can remove it if you use button instead
          implementation 'com.google.android.material:material:1.2.0-alpha03'
          ...
      }

## Create your ViewModel
1. Your ViewModel should extends `ViewModel` class
2. Wrap your attribute with `MutableLiveData`
3. Make a getter setter for that attribute
4. The rest of the code is written to support that attribute (e.g. nameList, Random())

      public class MainViewModel extends ViewModel {

          private List<String> nameList;
          private MutableLiveData<String> name;

          public MainViewModel(){
              // Initiate
              name = new MutableLiveData<>();
              nameList = new ArrayList<>();

              // Set Initial Value
              nameList.add("Andy");
              nameList.add("Barley");
              nameList.add("Charlie");
              nameList.add("Darwin");
              nameList.add("Elton");
              nameList.add("Foster");
              nameList.add("Georgie");
              nameList.add("Harley");
              nameList.add("Ivy");
              nameList.add("Jonathan");
          }

          public LiveData<String> getName(){
              return name;
          }

          public void setName(){
              // Randomize index for nameList
              Random rand = new Random();
              int idx = rand.nextInt(nameList.size());

              name.setValue(nameList.get(idx));
          }
      }


## Create your layout

      <?xml version="1.0" encoding="utf-8"?>
      <layout xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:app="http://schemas.android.com/apk/res-auto"
          xmlns:tools="http://schemas.android.com/tools">

          <data>
          <!-- Add your viewmodel to binding variable -->
              <variable
                  name="viewModel"
                  type="com.jonathandarwin.livedatadatabinding.MainViewModel"/>
          </data>

          <androidx.constraintlayout.widget.ConstraintLayout>
          
              <TextView
                  ...
                  // Bind your live data by using this binding variable
                  android:text="@{viewModel.name}"
                  ...
                   />
               
               <...>
               
          </androidx.constraintlayout.widget.ConstraintLayout>
          
      </layout>

## Initiate LiveData and DataBinding in your Activity      

      public class MainActivity extends AppCompatActivity {

          private MainActivityBinding binding;
          private MainViewModel viewModel;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);

              // Initiate Data Binding and View Model
              binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
              viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

              // Set ViewModel to Layout
              binding.setViewModel(viewModel);

              // Set Binding to Observe the Live Data
              // The Binding will automatically update when the Live Data is updated
              binding.setLifecycleOwner(this);

              // Set Name for the First Time
              viewModel.setName();

              // Set Listener
              binding.fabRefresh.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      viewModel.setName();
                  }
              });
          }
      }

      
