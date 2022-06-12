package com.example.dailyrunning.user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailyrunning.databinding.FragmentStatisticalBinding;

import org.jetbrains.annotations.NotNull;

public class StatisticalFragment extends Fragment {


    private FragmentStatisticalBinding binding;
    private UserViewModel userViewModel;
    private int currentPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //region get View
        binding = FragmentStatisticalBinding.inflate(inflater, container, false);
        //endregion

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        binding.setUserViewModel(userViewModel);
        binding.setLifecycleOwner(requireActivity());
        currentPage = getArguments().getInt("position");
        binding.setCurrentPage(currentPage);

    }

    public static Fragment newInstance(int position) {
        StatisticalFragment mCurrentFragment = new StatisticalFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        mCurrentFragment.setArguments(args);
        return mCurrentFragment;
    }


}
