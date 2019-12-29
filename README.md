# LiveData-DataBinding
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


