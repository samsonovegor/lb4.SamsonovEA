package timus;

import java.util.*;
        import java.io.*;

public class timus1151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        Map<Integer, Set<Long>> candidates = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            String line = br.readLine().trim();
            int colon = line.indexOf(':');
            String[] coord = line.substring(0, colon).split(",");
            int cx = Integer.parseInt(coord[0]);
            int cy = Integer.parseInt(coord[1]);
            String[] measurements = line.substring(colon + 1).split(",");
            for (String meas : measurements) {
                String[] parts = meas.split("-");
                int id = Integer.parseInt(parts[0]);
                int r = Integer.parseInt(parts[1]);
                Set<Long> ring = new HashSet<>();
                for (int x = Math.max(1, cx - r); x <= Math.min(200, cx + r); x++) {
                    for (int y = Math.max(1, cy - r); y <= Math.min(200, cy + r); y++) {
                        if (Math.max(Math.abs(x - cx), Math.abs(y - cy)) == r) {
                            ring.add((long) x * 201 + y);
                        }
                    }
                }
                if (!candidates.containsKey(id)) {
                    candidates.put(id, ring);
                } else {
                    candidates.get(id).retainAll(ring);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Set<Long>> e : candidates.entrySet()) {
            int id = e.getKey();
            Set<Long> pts = e.getValue();
            if (pts.size() == 1) {
                long v = pts.iterator().next();
                int x = (int) (v / 201);
                int y = (int) (v % 201);
                sb.append(id).append(':').append(x).append(',').append(y).append('\n');
            } else {
                sb.append(id).append(":UNKNOWN\n");
            }
        }
        System.out.print(sb);
    }
}
