INSERT INTO
  Artist (name, genre)
VALUES
  ('Leonardo da Vinci', 'Renaissance'),
  ('Vincent van Gogh', 'Post-Impressionism'),
  ('Pablo Picasso', 'Cubism'),
  ('Edward Hopper', 'American Modernism');

INSERT INTO
  Art (title, theme, artistId)
VALUES
  ('The Flight Study', 'Studies of Bird Wings', 1),
  ('Mona Lisa 2.0', 'Renaissance Portrait', 1),
  ('Starry Countryside', 'Night Landscape', 2),
  ('Sunflower Impressions', 'Floral', 2),
  ('Cubist Self-Portrait', 'Abstract Portrait', 3),
  ('Barcelona Abstracted', 'City Landscape', 3),
  ('Downtown Solitude', 'Urban Scene', 4),
  ('Night Cafe Redux', 'Modernist Interior', 4);

INSERT INTO
  Gallery (name, location)
VALUES
  ('Louvre Museum', 'Paris'),
  ('Van Gogh Museum', 'Amsterdam'),
  ('Museo Picasso', 'Barcelona'),
  ('Whitney Museum of American Art', 'New York');

INSERT INTO
  artist_gallery (artistId, galleryId)
VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 3),
  (3, 4),
  (4, 4);