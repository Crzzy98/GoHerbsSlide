package com.example.goherbs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragAdapter extends FragmentStatePagerAdapter {
    GoHerbsIcon goHerbsIcon = new GoHerbsIcon();
    SercondImage secondImage = new SercondImage();
    ThirdImage thirdImage = new ThirdImage();
    WebFrag webFrag = new WebFrag();
    final static int count = 4;
    static boolean locked = false;
    static int lockedPage;
    Fragment fragment[] = new Fragment[]{goHerbsIcon,secondImage,thirdImage,webFrag};

    public FragAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    public static void lockPage(boolean locked, int page) {
        FragAdapter.locked = locked;
        lockedPage = page;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        /*switch(position){
            case 0:
                GoHerbsIcon goHerbsIcon = new GoHerbsIcon();
                return goHerbsIcon;
            case 1:
                SercondImage secondImage = new SercondImage();
                return secondImage;
            case 2:
                ThirdImage thirdImage = new ThirdImage();
                return thirdImage;
            case 3:
                WebFrag webFrag = new WebFrag();
                lockPage(true);
                return webFrag;
            default:
                return null;
        }*/
        if (locked) return fragment[lockedPage];
        return fragment[position];
    }

    @Override
    public int getCount() {
        return count;
    }
}
