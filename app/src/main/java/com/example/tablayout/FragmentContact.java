package com.example.tablayout;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Contact> contactList;

    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_contact, container, false);

        myrecyclerview = v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), contactList);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeContact();
    }

    public void InitializeContact() {
        contactList = new ArrayList<>();
        String json;
        json = getJsonString();
        parseJson(json);
    }


    private String getJsonString() {
        String json = "";
        try {
            AssetManager am = getResources().getAssets();
            InputStream is = getActivity().getAssets().open("contact.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    private void parseJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray contactArray = jsonObject.getJSONArray("Contact");

            for (int i = 0; i < contactArray.length(); i++) {
                JSONObject contactObject = contactArray.getJSONObject(i);
                Contact contact = new Contact();
                contact.setName(contactObject.getString("name"));
                contact.setPhone(contactObject.getString("phone_number"));
                contactList.add(contact);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}