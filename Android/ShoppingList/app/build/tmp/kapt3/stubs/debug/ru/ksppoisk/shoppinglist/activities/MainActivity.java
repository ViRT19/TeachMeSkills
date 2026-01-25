package ru.ksppoisk.shoppinglist.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lru/ksppoisk/shoppinglist/activities/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lru/ksppoisk/shoppinglist/dialogs/NewListDialog$Listener;", "()V", "binding", "Lru/ksppoisk/shoppinglist/databinding/ActivityMainBinding;", "getBinding", "()Lru/ksppoisk/shoppinglist/databinding/ActivityMainBinding;", "setBinding", "(Lru/ksppoisk/shoppinglist/databinding/ActivityMainBinding;)V", "currentMenuItemId", "", "currentTheme", "", "defPref", "Landroid/content/SharedPreferences;", "getSelectedTheme", "onClick", "", "name", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setBottomNavListener", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements ru.ksppoisk.shoppinglist.dialogs.NewListDialog.Listener {
    public ru.ksppoisk.shoppinglist.databinding.ActivityMainBinding binding;
    private android.content.SharedPreferences defPref;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentTheme = "";
    private int currentMenuItemId;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.ksppoisk.shoppinglist.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.databinding.ActivityMainBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setBottomNavListener() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final int getSelectedTheme() {
        return 0;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
}