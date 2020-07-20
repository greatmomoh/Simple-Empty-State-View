# Simple-Empty-State-View

Simple UI tool to collate most of the features used in creating an empty state in android.

![sample image](https://github.com/greatmomoh/Simple-Empty-State-View/blob/master/Screenshot_1595242596.png?raw=true)

## Installation

### Method 1 - Gradle Dependency
- Add the jitpack repository to your root `build.gradle` file
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Add the latest dependency to your module's `build.gradle` file
```
dependencies {
    implementation 'com.github.greatmomoh:Simple-Empty-State-View:0.1.0'
}
```

## Usage

1. **Adding the view to the layout:**

```
   <com.great.momoh.simpleemptystateview.SimpleEmptyStateView
        android:id="@+id/no_tasks_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="@dimen/size_16"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"

        //available methods
        app:emptyStateImageSrc="@drawable/ic_launcher_background"
        app:emptyStateButtonText="@string/button_text"
        app:emptyStateTitleText="@string/title"
        app:emptyStateCaptionText="@string/caption"
        app:isButtonVisible="true"
        app:isTitleVisible="true"
        />
```

2. **Registering empty state button callback:**

```
  no_tasks_view.setActionBtnClickListener(object :
            SimpleEmptyStateView.ActionButtonClickListener {
                override fun invoke() {
                    Toast.makeText(this@MainActivity, getString(R.string.caption), Toast.LENGTH_LONG).show()
                }
            }
        )
```

## Contributing

- Create issues.
- Create PR's to fix said issues. 

## TODO

- Add more customization (colours, font size)
- Write tests and setup test automation.
