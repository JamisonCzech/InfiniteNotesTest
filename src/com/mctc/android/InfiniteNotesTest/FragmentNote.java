package com.mctc.android.InfiniteNotesTest;

import JavaClasses.NoteDataProvider;
import JavaClasses.NoteItemData;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 11/8/2014.
 */
public class FragmentNote extends ListFragment
{
   // Initialize member variables
   private NoteDataProvider mDataSource;
   //No args constructor
   public FragmentNote()
   {
   }
   // Debugger helpers
   private static final String TAG = "MainActivity";

   // initialize member variables
   private Context mContext;
   List <NoteItemData> mNoteLists;

   // initialize members for Toast object
   private Toast toast;
   private long lastBackPressTime = 0;


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
   {
      View view = inflater.inflate(R.layout.fragment_note, container, false);
// creates a new NoteDataProvider object
      // also saves persistently
     mDataSource = new NoteDataProvider(getActivity());

      Log.d(TAG, "fragmentInfiniteNotes Created");


     // refreshDisplay();

      refreshDisplay();

      return view;
   }
   private void refreshDisplay()
   {
      mNoteLists = mDataSource.findAll();

      ArrayAdapter<NoteItemData> adapter =
            new ArrayAdapter <NoteItemData>(getActivity(), R.layout.list_item_layout, mNoteLists);
      setListAdapter(adapter);


   }//
  private void CreateNote()
  {
   NoteItemData note = NoteItemData.getNew();
   Intent intent = new Intent(mContext, NoteItemData.class);
     intent.putExtra("key", note.getKey());
     intent.putExtra("text", note.getText());
     startActivityForResult(intent, 1001);
  }
   @Override
   public void onListItemClick(ListView l, View v , int position, long id)
   {
      NoteItemData note = noteList.get(position);
      Intent intent = new Intent(getActivity(), FragmentNote.class);
      intent.putExtra("key", note.getKey());
      intent.putExtra("text", note.getText());
      startActivityForResult(intent, 1001);// integer value
   }

}