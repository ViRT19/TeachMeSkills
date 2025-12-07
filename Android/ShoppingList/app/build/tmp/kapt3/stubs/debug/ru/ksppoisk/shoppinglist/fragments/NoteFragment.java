package ru.ksppoisk.shoppinglist.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006!"}, d2 = {"Lru/ksppoisk/shoppinglist/fragments/NoteFragment;", "Lru/ksppoisk/shoppinglist/fragments/BaseFragment;", "()V", "adapter", "Lru/ksppoisk/shoppinglist/db/NoteAdapter;", "binding", "Lru/ksppoisk/shoppinglist/databinding/FragmentNoteBinding;", "editLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "mainViewModel", "Lru/ksppoisk/shoppinglist/db/MainViewModel;", "getMainViewModel", "()Lru/ksppoisk/shoppinglist/db/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "initRcView", "", "observer", "onClickNew", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onEditResult", "onViewCreated", "view", "Companion", "app_debug"})
public final class NoteFragment extends ru.ksppoisk.shoppinglist.fragments.BaseFragment {
    private ru.ksppoisk.shoppinglist.databinding.FragmentNoteBinding binding;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> editLauncher;
    private ru.ksppoisk.shoppinglist.db.NoteAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NEW_NOTE_KEY = "new_note_key";
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.fragments.NoteFragment.Companion Companion = null;
    
    public NoteFragment() {
        super();
    }
    
    private final ru.ksppoisk.shoppinglist.db.MainViewModel getMainViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onClickNew() {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initRcView() {
    }
    
    private final void observer() {
    }
    
    private final void onEditResult() {
    }
    
    @kotlin.jvm.JvmStatic()
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.fragments.NoteFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lru/ksppoisk/shoppinglist/fragments/NoteFragment$Companion;", "", "()V", "NEW_NOTE_KEY", "", "newInstance", "Lru/ksppoisk/shoppinglist/fragments/NoteFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic()
        @org.jetbrains.annotations.NotNull()
        public final ru.ksppoisk.shoppinglist.fragments.NoteFragment newInstance() {
            return null;
        }
    }
}