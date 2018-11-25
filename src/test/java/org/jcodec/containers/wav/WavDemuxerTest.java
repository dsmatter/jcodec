package org.jcodec.containers.wav;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jcodec.codecs.wav.WavDemuxer;
import org.jcodec.common.io.NIOUtils;
import org.junit.Test;

import java.io.IOException;

public class WavDemuxerTest {
  @Test
  public void testBwfSampleFile() throws IOException {
    final WavDemuxer demuxer = new WavDemuxer(NIOUtils.readableFileChannel("src/test/resources/wav/bwf-stripped.wav"));
    try {
       assertEquals(48000, demuxer.getMeta().getAudioCodecMeta().getSampleRate());
       assertNotNull(demuxer.getBwf());
    } finally {
      demuxer.close();
    }
  }

  @Test
  public void testBigFmtChunkSampleFile() throws IOException {
    final WavDemuxer demuxer = new WavDemuxer(NIOUtils.readableFileChannel("src/test/resources/wav/fmt40.wav"));
    try {
      assertEquals(48000, demuxer.getMeta().getAudioCodecMeta().getSampleRate());
    } finally {
      demuxer.close();
    }
  }
}
