package utils;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

import controller.LocalController;

import org.jxmapviewer.viewer.Waypoint;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import model.entities.Local;

public class Map {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mapa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JXMapViewer mapViewer = new JXMapViewer();

        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        tileFactory.setThreadPoolSize(8);

        mapViewer.setTileFactory(tileFactory);

        GeoPosition position = new GeoPosition(-25.5469, -54.5882); // Foz do Iguaçu, Brasil
        mapViewer.setAddressLocation(position);

        mapViewer.setZoom(7);

        MouseAdapter panMouseListener = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(panMouseListener);
        mapViewer.addMouseMotionListener(panMouseListener);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        LocalController localController = new LocalController();
        List<Local> locais = localController.findAll();

        Set<Waypoint> waypoints = new HashSet<>();
        for (Local local : locais) {
            GeoPosition geoPosition = new GeoPosition(Double.parseDouble(local.getLatitudeY()), Double.parseDouble(local.getLatitudeX()));
            waypoints.add(new DefaultWaypoint(geoPosition));
        }

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        mapViewer.setOverlayPainter(waypointPainter);

        frame.getContentPane().add(mapViewer);

        frame.setVisible(true);
    }
}
