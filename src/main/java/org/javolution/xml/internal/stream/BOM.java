package org.javolution.xml.internal.stream;

public enum BOM {
  /** UTF-8 BOM (EF BB BF). */
  UTF_8(new int[]{0xEF, 0xBB, 0xBF}, "UTF-8"),

  /** UTF-16, little-endian (FF FE). */
  UTF_16_LE(new int[]{0xFF, 0xFE}, "UTF-16LE"),

  /** UTF-16, big-endian (FE FF). */
  UTF_16_BE(new int[]{0xFE, 0xFF}, "UTF_16BE"),

  /** * UTF-32, little-endian (FF FE 00 00). */
  UTF_32_LE(new int[]{
      0xFF, 0xFE, 0x00, 0x00}, "UTF-32LE"),

  /** UTF-32, big-endian (00 00 FE FF). */
  UTF_32_BE(new int[]{0x00, 0x00, 0xFE, 0xFF}, "UTF-32BE");

  final int[] bytes;
  final String encodingName;


  BOM(int[] bytes, final String encodingName) {
    this.bytes = bytes;
    this.encodingName = encodingName;
  }

  /**
   * @return Encoding name.
   */
  public final String toString() {
    return encodingName;
  }

  /**
   * @return bytes corresponding to this BOM value.
   */
  public final int[] getBytes() {
    final int[] result = new int[bytes.length];
    System.arraycopy(bytes, 0, result, 0, bytes.length);
    return result;
  }

}
