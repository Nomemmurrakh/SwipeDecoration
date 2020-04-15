## SwipeDecoration

### What is it?
A simple class for applying decoration to RecyclerView when user swipes left or right.

#### Keypoints:
- This class follows Builder Pattern for step-by-step creation, please use the Builder class to build SwipeDecoration.
- This class is tested with `ItemTouchHelper` utility class. 
- You may build SwipeDecoration outside of `ItemTouchHelper` 
- Always Remember to call `applyDecoration` method of SwipeDecoration inside `OnChildDraw` of ItemTouchHelper callback.
- This class also supports `AnimatedVectorDrawable`

## How to use it?

#### Basic Code:
```
...
private SwipeDecoration decoration;

// You can initialize/build it outside of ItemTouchHelper.

decoration = new SwipeDecoration.Builder(context)
                .setIconLeftResource(R.drawable.ic_remove)
                .setIconRightResource(R.drawable.ic_send)
                .build();
                
// Then inside of ItemTouchHelper OnChildDraw

@Override
public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
  super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

  decoration.applyDecoration(c, viewHolder, dX); // This applies the decoration.
  
}
```
#### Change Icon Position:

To change the position of the icon, you can use one of the following:

- BEHAVIOUR_STATIC_START (Default)
- BEHAVIOUR_STATIC_END
- BEHAVIOUR_STATIC_CENTER
- BEHAVIOUR_DYNAMIC

###### Note: The description is available in the javadoc.

```
decoration = new SwipeDecoration.Builder(context)
                .setIconLeftResource(R.drawable.ic_remove)
                .setIconRightResource(R.drawable.ic_send)
                .setIconLeftBehaviour(SwipeDecoration.BEHAVIOUR_STATIC_START)
                .setIconRightBehaviour(SwipeDecoration.BEHAVIOUR_STATIC_END)
                .build();
```

#### Icon Animation:

To give the icons animation as the view moves, use one of the following:

- NO_ANIMATION (Default)
- ANIMATION_FADE
- ANIMATION_ROTATE

###### Note: The description is available in the javadoc.

```
decoration = new SwipeDecoration.Builder(context)
                .setIconLeftResource(R.drawable.ic_remove)
                .setIconRightResource(R.drawable.ic_send
                .setIconLeftAnimation(SwipeDecoration.ANIMATION_FADE)
                .setIconRightAnimation(SwipeDecoration.ANIMATION_ROTATE)
                .build();
```

#### AnimatedVectorDrawables:

You can also use AnimatedVectorDrawables, the animation will be played if supported.
When using AnimatedVectorDrawables, Icon Animation will not work if specified on that Drawable.
However, you can still set the Icon Behaviour.

```
decoration = new SwipeDecoration.Builder(context)
                .setIconLeftResource(R.drawable.ic_remove)
                .setIconRightResource(R.drawable.animated_vector_send)
                .build();
```

#### Change Background:

You can change the backgroundColor or use a Drawable/GradientDrawable as a background.

```
decoration = new SwipeDecoration.Builder(context)
                .setIconLeftResource(R.drawable.ic_remove)
                .setIconRightResource(R.drawable.animated_vector_send)
                .setBackgroundLeftColor(Color.CYAN)
                .setBackgroundRightColor(Color.GRAY)
                .build();
```

## Implementation

#### Add Maven Repository

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

#### Add dependency

```
dependencies {
  ...
  implementation 'com.github.Nomemmurrakh:SwipeDecoration:v<VERSION>'
}
```

####  Current Version:

[![](https://jitpack.io/v/Nomemmurrakh/SwipeDecoration.svg)](https://jitpack.io/#Nomemmurrakh/SwipeDecoration)
