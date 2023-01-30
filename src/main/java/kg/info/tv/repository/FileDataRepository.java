package kg.info.tv.repository;

import kg.info.tv.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    FileData findByName(String fileName);
    @Query(value = "SELECT file_path FROM file_data u WHERE u.id = ?1", nativeQuery = true)
    String findByFile_path(Integer file_data);
}
