package hjapp.com.hjclass_mobile;

import android.content.Intent;

final class ab
  implements Runnable
{
  ab(HJClassPlayerV3 paramHJClassPlayerV3)
  {
  }

  public final void run()
  {
    Intent localIntent = this.a.getIntent();
    this.a.startActivity(localIntent);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     ab
 * JD-Core Version:    0.6.2
 */