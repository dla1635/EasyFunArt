import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.hongik.jwlim.easyfunart.Activity.DisplayFragment
import com.hongik.jwlim.easyfunart.Activity.GalleryFragment
import com.hongik.jwlim.easyfunart.Activity.ReviewFragment


class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var tabCount : Int = 0
    var firtTab : DisplayFragment? = null
    var secondTab : GalleryFragment? = null
    var thirdTab : ReviewFragment? = null

    constructor(fm : FragmentManager?, tabCount : Int) : this(fm){
        this.tabCount = tabCount
        this.firtTab = DisplayFragment()
        this.secondTab = GalleryFragment()
        this.thirdTab = ReviewFragment()
    }

    override fun getItem(position: Int): Fragment? {
        when(position){
            0-> {
                val bundle = Bundle()
                bundle.putString("title", "전시정보")
                firtTab!!.arguments = bundle

                return firtTab
            }
            1-> {
                val bundle = Bundle()
                bundle.putString("title", "갤러리정보")
                secondTab!!.arguments = bundle
                return secondTab
            }
            2-> {
                val bundle = Bundle()
                bundle.putString("title", "리뷰")
                thirdTab!!.arguments = bundle
                return thirdTab
            }
        }

        return null
    }

    override fun getCount(): Int = tabCount
}
