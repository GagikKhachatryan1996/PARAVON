package com.aca.paravon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int countTab;

    public PagerAdapter(@NonNull FragmentManager fm,int contTab) {
        super(fm);
        this.countTab =contTab;
    }



    @NonNull
    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                UteliqneriFragment tabOne=new UteliqneriFragment();
                return tabOne;
            case 1:
                XmichqneriFragment tabTwo=new XmichqneriFragment();
                return tabTwo;
            case 2:
                CxaxotneriFragment tabThree=new CxaxotneriFragment();
                return tabThree;
                default:
                    return null;


        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
