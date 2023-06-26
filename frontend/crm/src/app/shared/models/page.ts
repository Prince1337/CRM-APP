export interface Page<T> {
  content: T[];          // Liste der Elemente auf der aktuellen Seite
  totalPages: number;    // Gesamtanzahl der Seiten
  totalElements: number; // Gesamtanzahl der Elemente
  number: number;        // Aktueller Seitenindex (0-basiert)
  size: number;          // Anzahl der Elemente pro Seite
  first: boolean;        // True, wenn dies die erste Seite ist
  last: boolean;         // True, wenn dies die letzte Seite ist
}
