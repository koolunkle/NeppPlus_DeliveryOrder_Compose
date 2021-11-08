package com.neppplus.deliveryorder_20211108.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.neppplus.deliveryorder_20211108.fragments.MyProfileFragment
import com.neppplus.deliveryorder_20211108.fragments.PizzaStoreListFragment

class MainViewPagerAdapter( fm: FragmentManager ) : FragmentPagerAdapter(fm) {
//  * Adapter는 자식 View를 만들어 데이터를 담는다.

    override fun getPageTitle(position: Int): CharSequence? {
//  * getPageTitle : 페이지 제목을 반환한다.
        return when(position) {

            0 -> "피자 주문"
            else -> "내 정보 설정"
//      * return when : 상황별(position)로 데이터를 반환한다.
//      * Tip : if문 사용보다 코드를 간결하게 작성할 수 있다.

        }

    }

    override fun getCount(): Int {
        return 2
//  * getCount : 데이터의 개수를 확인한다. 우리가 작업할 데이터는 PizzaStore & MyProfile 총 2개이다.
    }

    override fun getItem(position: Int): Fragment {
//  * getItem : position의 데이터를 반환한다.
        return when(position) {
            0 -> PizzaStoreListFragment()
            else -> MyProfileFragment()
//  * return when : 상황별(position)로 데이터를 반환한다.
//  * Tip : if문 사용보다 코드를 간결하게 작성할 수 있다.
        }

    }

}