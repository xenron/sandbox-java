package hjapp.com.hujiang.util;

public final class HJFile
{
  static
  {
    System.loadLibrary("dec");
  }

  public final native void decode(Object paramObject, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, boolean paramBoolean);

  public final native void digOut(Object paramObject, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean);

  public final native void fillBack(Object paramObject, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean);
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HJFile
 * JD-Core Version:    0.6.2
 */